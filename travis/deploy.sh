#!/usr/bin/env bash
echo $ENV_WITH_SPACES
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn verify -P sign,build-extras --settings travis/settings.xml
fi
