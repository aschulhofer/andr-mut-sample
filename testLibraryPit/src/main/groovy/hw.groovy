if(args.length > 0) {
//    def cmd = ("cmd.exe /c " + args[0])
    def cmd = args[0]
    def numMutants = args[1] as Integer

    def outputConsole = false;
    if(args.length > 1) {
        outputConsole = args[2] as Boolean
    }

    def mutantIds = 0..numMutants
    def mutants = mutantIds.collect { "mutant" + it }

    println cmd
    println mutants

    mutants.each { mutant ->
        def mutantCmd = cmd + " " + mutant

        println mutantCmd

        def process = mutantCmd.execute()
        def sb = new StringBuffer()
        process.consumeProcessErrorStream(sb)

        if(outputConsole) {
            process.inputStream.eachLine {println it}
        }
        else {
            println proc.text
        }

        println sb.toString()
    }

    println "finished mutation."
}
else {
    println "Invalid call."
}
