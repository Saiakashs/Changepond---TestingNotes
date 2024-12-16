function register({ firstName, lastName, email, contact, password, confirmPassword, role, branch, gender }) {
    if (!firstName || !lastName || !email || !contact || !password || !confirmPassword || !role || !branch || !gender) {
      return { success: false, message: "All fields are required" };
    }
    if (password !== confirmPassword) {
      return { success: false, message: "Passwords do not match" };
    }
    if (password.length < 6) {
      return { success: false, message: "Password must be at least 6 characters" };
    }
    if (!/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(email)) {
      return { success: false, message: "Invalid email format" };
    }
    if (!/^\d{10}$/.test(contact)) {
      return { success: false, message: "Contact number must be 10 digits" };
    }
    return { success: true, message: "Registration successful" };
  }
 
  module.exports = { register };
 