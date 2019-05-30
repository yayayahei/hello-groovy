import org.codehaus.groovy.runtime.typehandling.GroovyCastException

assert 'c'.getClass() == String
assert "c".getClass() == String
assert "c${1}".getClass() in GString

char a = 'a'
assert Character.digit(a, 16) == 10: 'But Groovy does boxing'
assert Character.digit((char) 'a', 16) == 10

try {
    assert Character.digit('a', 16) == 10
    assert false: 'Need explicit cast'
} catch (MissingMethodException e) {
}

// for single char strings, both are the same
assert ((char) "c").class == Character
assert ("c" as char).class == Character

// for multi char strings they are not
try {
    ((char) 'cx') == 'c'
    assert false: 'will fail - not castable'
} catch (GroovyCastException e) {
}
assert ('cx' as char) == 'c'
assert 'cx'.asType(char) == 'c'