#!/bin/bash

title () {
x="$1"

echo "$x" | tr "[:upper:]" "[:lower:]" | sed -E "s/(^|[^a-zA-Z])([a-z])/\1\U\2/g"
}