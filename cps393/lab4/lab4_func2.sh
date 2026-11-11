#!/bin/bash

capitalize () {
x="$1"

echo "$x" | tr "[:upper:]" "[:lower:]" | sed "s/^./\U&/" 
}