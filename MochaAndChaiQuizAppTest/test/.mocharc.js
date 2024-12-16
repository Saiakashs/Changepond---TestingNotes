//module.exports = { ui : 'tdd' }

module.exports = {
    // ui : 'tdd'
    ui: 'bdd',
    timeout: 2000,//Timeout after 2000 ms
    slow: 150,
    reporter:'spec',
    retries: 1,//(last precedence)testcase execution count, if it is 3, then testcase will execute 3 times after 1st and 2nd attempt fails
    ui: 'bdd',
    'watch-files': ['test/**/*.js'],
 }