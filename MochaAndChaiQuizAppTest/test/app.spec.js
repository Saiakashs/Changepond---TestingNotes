let expect;
 
before(async () => {
  const chai = await import('chai'); // Dynamically import Chai
  expect = chai.expect;
});
 
const { register } = require('../src/app'); // Assuming app.js is in the same directory
 
describe('Student Registration', function() {
 
  it('should fail if any field is missing', function() {
    const result = register({ email: "test@example.com", password: "password", confirmPassword: "password" });
    expect(result.success).to.be.false;
    expect(result.message).to.equal("All fields are required");
  });
 
  it('should fail if passwords do not match', function() {
    const result = register({
      firstName: "John", lastName: "Doe", email: "test@example.com", contact: "1234567890",
      password: "password123", confirmPassword: "password", role: "Student", branch: "CDAC", gender: "Male"
    });
    expect(result.success).to.be.false;
    expect(result.message).to.equal("Passwords do not match");
  });
 
  it('should fail if password is less than 6 characters', function() {
    const result = register({
      firstName: "John", lastName: "Doe", email: "test@example.com", contact: "1234567890",
      password: "pass", confirmPassword: "pass", role: "Student", branch: "CDAC", gender: "Male"
    });
    expect(result.success).to.be.false;
    expect(result.message).to.equal("Password must be at least 6 characters");
  });
 
  it('should fail if email format is invalid', function() {
    const result = register({
      firstName: "John", lastName: "Doe", email: "invalid-email", contact: "1234567890",
      password: "password123", confirmPassword: "password123", role: "Student", branch: "CDAC", gender: "Male"
    });
    expect(result.success).to.be.false;
    expect(result.message).to.equal("Invalid email format");
  });
 
  it('should fail if contact number is not 10 digits', function() {
    const result = register({
      firstName: "John", lastName: "Doe", email: "test@example.com", contact: "12345",
      password: "password123", confirmPassword: "password123", role: "Student", branch: "CDAC", gender: "Male"
    });
    expect(result.success).to.be.false;
    expect(result.message).to.equal("Contact number must be 10 digits");
  });
 
  it('should succeed if all fields are valid', function() {
    const result = register({
      firstName: "John", lastName: "Doe", email: "test@example.com", contact: "1234567890",
      password: "password123", confirmPassword: "password123", role: "Student", branch: "CDAC", gender: "Male"
    });
    expect(result.success).to.be.true;
    expect(result.message).to.equal("Registration successful");
  });
 
});
 