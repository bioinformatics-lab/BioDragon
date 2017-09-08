$arr = Get-ChildItem -Filter *R1* -Name


foreach ($a in $arr) {
                cat $a | Set-Content out.txt
                #Write-Host $a

}

get-help Add-Content