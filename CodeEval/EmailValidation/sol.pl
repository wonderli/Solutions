#!/usr/bin/env perl
#print "@ARGV[0]\n";
open(INFILE, "<@ARGV[0]") or die("Cannot open file @ARGV[0] for reading: $!");
while(my $line = <INFILE>) {
    next if($line =~ m/^s$/); # skip blank lines
    $line =~ s/(^s|s*$)//g; # remove leading and trailing spaces
    if($line =~ m/^[a-z0-9]*@[a-z0-9]*\.[a-z0-9]*$/){
        print "true\n";
    }else {
        print "false\n"
    };

}
close(INFILE);
