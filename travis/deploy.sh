#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn verify -P sign,build-extras --settings travis/settings.xml
fi
