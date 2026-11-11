#!/bin/bash

casefold () {
  x="$1"
  echo "$x" | tr "A-Z" "a-z" 
}