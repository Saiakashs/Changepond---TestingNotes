const {add, sub} = require('../src/app2')

let expect;
(async () => {
  const chai = await import('chai');  //importing chai explicitly
  expect = chai.expect;
})();
 
const {suite,test,setup,teardown,suiteSetup,suiteTeardown}=require('mocha')


//import {suite,test,setup,teardown,suiteSetup,suiteTeardown} from 'mocha'
suite('TDD hooks', () => {
    suiteSetup(() => {
        console.log('one suitesetup')
    });
    suiteTeardown(() => {
        console.log('one suiteteardown')
    });
    setup(() => {
        console.log('one setup')
    });
    teardown(() => {
        console.log('one teardown')
    });
    // test cases
    test('add(7,3) should return 10', () => {
        console.log('one test')
    });
});

//BDD hooks
 describe('Suite 4', ()=> {
   before(()=> {
      // runs once before the first test in this block
      console.log('before')
     });
 
    after(()=> {
      // runs once after the last test in this block
      console.log('after')
         });
 
    beforeEach(()=> {
      // runs before each test in this block
      console.log('beforeEach')
        });
 
    afterEach(()=> {
    // runs after each test in this block
     console.log('afterEach')
    });
 
   it('add(2,3) should retuen 5', ()=> {
       expect(add(2,3)).to.be.equal(5);
      console.log('it')
  })
//     // test cases
   });