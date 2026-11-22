#!/bin/bash

x="$1"

if [[ ! -f "$x" ]]; then 
	exit 1
fi

cat "$x" | tr -s '[:print:]'