#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    COMMIT_MSG=`git show $TRAVIS_COMMIT --quiet --pretty=format:%s`
    COMMIT_MSG_UPPER=`echo $COMMIT_MSG | awk '{print toupper($0)}'`
    if [[ $COMMIT_MSG_UPPER == RELEASE:* ]]; then
        RELEASE_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*RELEASEVERSION=\(.*\)[[:space:]]'`
        DEVELOPMENT_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*DEVELOPMENTVERSION=\(.*\)$'`
        if [ -z $RELEASE_VERSION ]; then
            RELEASE_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*RELEASEVERSION=\(.*\)$'`
            DEVELOPMENT_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*DEVELOPMENTVERSION=\(.*\)[[:space:]]'`
        fi

        if [ -z $RELEASE_VERSION ] || [ -z $DEVELOPMENT_VERSION ]; then
            echo "releaseVersion or developmentVersion not specified in commit msg"
            echo "example: RELEASE: releaseVersion=0.0.1 developmentVersion=0.0.2-SNAPSHOT"
            exit 1
        fi

        git checkout master
        git config user.email "oss@kenzan.com"
        git config user.name "Kenzan OSS"
        echo -e "machine github.com\n  login $GITHUB_ACCESS_TOKEN" >> ~/.netrc
        mvn release:clean release:prepare -P sign,build-extras --settings travis/settings.xml -DreleaseVersion=$RELEASE_VERSION -Dtag=$RELEASE_VERSION -DdevelopmentVersion=$DEVELOPMENT_VERSION
        mvn release:perform
    else
        mvn deploy -P sign,build-extras --settings travis/settings.xml
    fi
fi
