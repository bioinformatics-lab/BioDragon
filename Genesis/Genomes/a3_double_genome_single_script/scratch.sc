#!/usr/bin/env amm

import ammonite.ops._



println(pwd)

mkdir! pwd/"analysis"

cp.into(pwd/"test.sc", pwd/"analysis")

//cd! pwd/"analysis"

ls! pwd/"analysis"



