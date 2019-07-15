#!/usr/bin/env bash

if [[ $(git diff --stat) != '' ]]; then
  echo "Error: dirty repo"
  exit 1
elif [[ $(git rev-parse --show-toplevel) != $(pwd) ]]; then
  echo "Error: Not in root directory"
  exit 1
# elif [ -z "$CLOJARS_USERNAME" ]; then
#   echo "Error: CLOJARS_USERNAME is empty"
#   exit 1
# elif [ -z "$CLOJARS_PASSWORD" ]; then
#   echo "Error: CLOJARS_PASSWORD is empty"
#   exit 1
fi
