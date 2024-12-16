const axios = require('axios')
 
let expect;
(async () => {
  const chai = await import('chai');
  expect = chai.expect;
})();
 
describe('Test Suite 1', function() {        //describe.skip and describe.only can also be demonstrated here
    this.retries(1); // Retry all tests in this suite up to 1 times
     it('promised based way', function() {
      this.retries(2); // Retry this specific test case up to 2 times
 
      return axios.get('https://reqres.in/api/users?page=2')
        .then(res => {
          expect(res.data.data[1].email).to.equal('lindsay1.ferguson@reqres.in');
        })
        .catch(err => {
          // Handle any errors during the Axios request or assertion
          console.error('Error during test:', err);
          throw err; // Rethrow the error to trigger Mocha's retry mechanism
        });
    });
  });