
when 'Ready for Test', {
    'success' should: 'Pass'
}

when 'Ready for Test', {
    'failure' should: 'Fail'
}

when 'Fail', {
    'success' should: 'Pass'
}

when 'Pass', {
    'failure' should: 'Fail'
}

when 'Blocked', {
    'success' should: 'Pass'
}

when 'Blocked', {
    'failure' should: 'Fail'
}

when 'Under Maintenance', {
    'success' should: 'Pass'
}

when 'Under Maintenance', {
    'failure' should: 'Fail'
}