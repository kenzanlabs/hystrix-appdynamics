#!/usr/bin/env bash
echo $GPG_KEY_NAME
echo $GPG_PASSPHRASE
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn verify -P sign,build-extras --settings travis/settings.xml
fi
