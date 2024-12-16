const axios = require('axios')  //Require for API Testing
 
let expect;
(async () => {
  const chai = await import('chai');
  expect = chai.expect;
})();
 
 
describe('Test Suite 1', ()=>{
    it('promised based way', function (){      
     
        return axios.get('https://reqres.in/api/users?page=2').then(res =>{
            expect(res.data.data[1].email).to.be.equal('lindsay.ferguson@reqres.in')
            expect(res.data.data[1].id).to.be.equal(8)
 
        })
    })
});