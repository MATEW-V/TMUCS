#!/bin/bash

while IFS= read -r line; do
	if [[ "$line" == *"."* ]]; then
		intp=$(echo "$line" | grep -o -E "^[0-9]+")
		floatp=$(echo "$line" | grep -o -E "\.[0-9]+$")
		echo "$intp + 0$floatp = $line"
	else 
		echo "$line"
	fi
done 