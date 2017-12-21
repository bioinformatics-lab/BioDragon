#!/usr/bin/env amm

import ammonite.ops._



println(wd)

mkdir! pwd/"analysis"

cp.into(wd/"test.sc", wd/"analysis")

cd! pwd/"analysis"

ls!
