#!/usr/bin/env bash
sleep 3
if [[ `cat target/native-image/test-output.txt | grep -E "QUERY BY EXAMPLE"` ]]
then
  exit 0
else 
  exit 1
fi
