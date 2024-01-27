sub is_empty() {
    return $_ =~ /^\s*$/
}

sub prepare_string() {
    s/^(\s+)(.*)/$2/g;
    s/(\s+)$//g;

    s/\s+/ /g;
}

sub println() {
    print "$_\n";
}

sub clean_html_tag() {
    s/<.*?>//g;
}

$is_start = 1;
$empty_line_met = 0;

while (<STDIN>) {
    clean_html_tag;

    if (!is_empty) {
        $is_start = 0;
    }

    if (!$is_start) {
        prepare_string;

        if (is_empty) {
            $empty_line_met = 1;
            next;
        }

        print "\n" if $empty_line_met;
        $empty_line_met = 0;
        println;
    }
}
