get-childItem "./*.csv" 
| ForEach-Object {[System.IO.File]::AppendAllText
                ("./merged.csv", [System.IO.File]::ReadAllText($_.FullName))}
