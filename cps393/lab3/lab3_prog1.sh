#!/bin/bash
last | grep -i "$1" | cut -d ' ' -f 1 | sort | uniq