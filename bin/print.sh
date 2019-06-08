#! /bin/bash

set -e

export CYAN="\033[1;36m"
export RED="\e[31m"
export WHITE="\e[97m"
export GREEN="\e[32m"

NC="\033[0m"

# Prints header message
print_header () {
  msg=$1

  printf "\n${CYAN}-------------------------------------\n${msg}
-------------------------------------${NC}\n"
}

# Prints message in color
print_message () {
  msg=$1
  color=$2

  printf "\n${color}${msg}${NC}\n"
}
