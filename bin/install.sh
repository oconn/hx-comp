#! /bin/bash

set -e

source ./bin/print.sh

print_message "Installing NPM packages..." $WHITE

yarn install

print_message "NPM packages installed" $GREEN

print_message "Bundling NPM dependencies..." $WHITE

yarn webpack

print_message "NPM dependencies bundled" $GREEN
