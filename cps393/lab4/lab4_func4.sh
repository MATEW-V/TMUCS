#!/bin/bash

repeat () {
res=""
x="$1"
n="$2" 

for ((i=0; i<"$n"; i++)); do
  res+="$x"
done

echo "$res"
} 