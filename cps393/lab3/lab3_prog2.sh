#!/bin/bash
x="$1"

if [[ ! -f "$x" ]]; then 
	echo "$x is not a file">&2
	exit 1
fi

while IFS= read -r line ; do
	catc=0
	dogc=0
	for word in $line; do 
		if [[ "$word" == "cat" || "$word" == "tac" ]]; then
			((catc++))
		elif [[ "$word" == "dog" || "$word" == "god" ]]; then
			((dogc++))
		fi
	done
	
	if (( catc > dogc )); then
		echo "MEOW"
	elif (( dogc > catc )); then
		echo "WOOF"
	else
		echo "SAME"
	fi
done <"$x"	