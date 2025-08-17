const formOpenBtn = document.querySelector("#form-open"),
  home = document.querySelector(".home"),
  formContainer = document.querySelector(".form_container"),
  formCloseBtn = document.querySelector(".form_close"),
  signupBtn = document.querySelector("#signup"),
  loginBtn = document.querySelector("#login"),
  pwShowHide = document.querySelectorAll(".pw_hide");

formOpenBtn.addEventListener("click", () => home.classList.add("show"));
formCloseBtn.addEventListener("click", () => home.classList.remove("show"));

pwShowHide.forEach((icon) => {
  icon.addEventListener("click", () => {
    const passwordInput = icon.parentElement.querySelector("input");
    if (passwordInput.type === "password") {
      passwordInput.type = "text";
      icon.classList.replace("uil-eye-slash", "uil-eye");
    } else {
      passwordInput.type = "password";
      icon.classList.replace("uil-eye", "uil-eye-slash");
    }
  });
});

signupBtn.addEventListener("click", (event) => {
  event.preventDefault();
  formContainer.classList.add("active");
});
loginBtn.addEventListener("click", (event) => {
  event.preventDefault();
  formContainer.classList.remove("active");
});

// Minimal demo login - posts to /auth/login with hardcoded demo credentials if fields are empty
const loginForm = document.getElementById('loginForm');
const loginSubmit = document.getElementById('login-submit');
async function doLogin(){
  if (!loginForm) return;
  const emailInput = loginForm.querySelector('input[type="email"]');
  const passwordInput = loginForm.querySelector('input[type="password"]');
  const email = ((emailInput && emailInput.value) ? emailInput.value : '').trim() || 'demo@bookreviews.com';
  const password = ((passwordInput && passwordInput.value) ? passwordInput.value : '').trim() || 'Demo@12345';
  const msg = document.getElementById('loginMessage');
  if (msg) { msg.style.color = '#555'; msg.textContent = 'Signing in...'; }
  try {
    const res = await fetch('http://localhost:8081/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email, password })
    });
    if (res.ok) {
      // Try to capture user info for later (used to auto-fill review name)
      let payload = null;
      try { payload = await res.clone().json(); } catch(e) { payload = null; }
      console.log('Login response payload:', payload);
      
      // Store complete user information
      if (payload) {
        const userName = payload.userName || email;
        const userId = payload.userId;
        const firstName = payload.firstName;
        const lastName = payload.lastName;
        const emailId = payload.emailId;
        
        console.log('Setting username to:', userName);
        console.log('Complete user data:', payload);
        
        // Store user data in localStorage
        try { 
          localStorage.setItem('cb_userName', userName); 
          localStorage.setItem('cb_userId', userId);
          localStorage.setItem('cb_firstName', firstName);
          localStorage.setItem('cb_lastName', lastName);
          localStorage.setItem('cb_emailId', emailId);
          localStorage.setItem('cb_fullUserProfile', JSON.stringify(payload));
        } catch(e) {}
        
        // Store username in cookies for compatibility
        try { document.cookie = 'cb_userName=' + encodeURIComponent(userName) + '; path=/; max-age=604800'; } catch(e) {}
      } else {
        // Fallback to just storing username
        const userName = email;
        try { localStorage.setItem('cb_userName', userName); } catch(e) {}
        try { document.cookie = 'cb_userName=' + encodeURIComponent(userName) + '; path=/; max-age=604800'; } catch(e) {}
      }
      
      if (msg) { msg.style.color = '#1b5e20'; msg.textContent = 'Login successful. Redirecting...'; }
      window.location.replace('/books.html');
    } else {
      const text = await res.text().catch(()=> '');
      if (msg) { msg.style.color = '#b00020'; msg.textContent = 'Login failed: ' + (text || res.status); } else { alert('Login failed: ' + (text || res.status)); }
    }
  } catch (err) {
    console.error('Login error:', err);
    if (msg) { msg.style.color = '#b00020'; msg.textContent = 'Network error: ' + (err && err.message ? err.message : err); } else { alert('Network error: ' + (err && err.message ? err.message : err)); }
  }
}
if (loginForm) {
  loginForm.addEventListener('submit', (e) => { e.preventDefault(); doLogin(); });
}
if (loginSubmit) {
  loginSubmit.addEventListener('click', (e) => { e.preventDefault(); doLogin(); });
}

// Extra safety: delegate click if direct binding was missed
document.addEventListener('click', (e) => {
  const btn = e.target && e.target.closest && e.target.closest('#login-submit');
  if (btn) {
    e.preventDefault();
    // Ensure async call is not blocked
    setTimeout(doLogin, 0);
  }
});

// Fallback: Enter key on password field should trigger login
const pwField = document.querySelector('.login_form input[type="password"]');
if (pwField) {
  pwField.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();
      doLogin();
    }
  });
}

// Expose for manual testing from console
window.doLogin = doLogin;


