#!/bin/bash

case "$1" in 
	W|L)
l1=$(echo "$1" | tr "A-Z" "a-z")
;;
	C)
l1="m"
;;
	*)
echo "not a valid param"
exit 1
;;
esac

nfc=$(wc -"$l1" < "$2")
fname=$(echo "$2" | sed 's/\..*//')
ext=$(echo "$2" | sed 's/.*\.//')

cp "$2" "${fname}_${nfc}${1}.${ext}"