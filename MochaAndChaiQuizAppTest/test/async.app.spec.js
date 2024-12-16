const axios = require('axios');  // Required for API Testing
 
let expect;
before(async () => {
  const chai = await import('chai');
  expect = chai.expect;
});
 
describe('Test Suite 1', () => {
  it('promised based way', function () {
    return axios.get('http://quiz-be-test.hematitecorp.com/api/user/').then(res => {
      expect(res.data.data[2].fname).to.be.equal('monica');
      expect(res.data.data[1].id).to.be.equal(2);
    });
  });
});