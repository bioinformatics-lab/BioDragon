
// TODO: figure out why we're unable to simply do << amm genesis.sc >>

// import ammonite.ops._
// import ammonite.ops.ImplicitWd._





/*
interp.load.ivy(
  "com.lihaoyi" %
    s"ammonite-shell_${scala.util.Properties.versionNumberString}" %
    ammonite.Constants.version
)


// interp.load.ivy("com.lihaoyi" % "ammonite-shell_2.12.4" % "1.0.3")


val shellSession = ammonite.shell.ShellSession()
import shellSession._
import ammonite.ops._
import ammonite.shell._
ammonite.shell.Configure(interp, repl, wd)

 */




import $file.analysis


analysis.analyse_all_genomes(List("G04870"))

 // Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.

// var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList


//analyse_all_genomes(unique_genome_list)



