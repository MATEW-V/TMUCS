#!/bin/bash

x="$1" 

if [[ ! -f "$x" ]]; then 
	exit 1
fi
count=0
res=""

while IFS= read -r line; do
	lwcount=$(wc -w <<< "$line")
	if (( "$lwcount" > "$count" )); then
		count="$lwcount"
		res="$line"
	fi
done < "$x"

echo "$res has $count words"