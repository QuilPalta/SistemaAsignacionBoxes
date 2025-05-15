import { authenticate } from './auth.js';

export function setupAuthHandlers() {
  // Login functionality
  document.getElementById('loginBtn').addEventListener('click', async function () {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    
    try {
      document.getElementById('loginScreen').classList.add('hidden');
      document.getElementById('loadingScreen').classList.remove('hidden');
      
      const response = await authenticate(email, password);
      
      if (response.success) {
        document.querySelector('#userMenuBtn span').textContent = response.user.name;
        document.querySelector('#userMenuBtn div').textContent = response.user.name.charAt(0);
        
        setTimeout(() => {
          document.getElementById('loadingScreen').classList.add('hidden');
          document.getElementById('dashboard').classList.remove('hidden');
        }, 1000);
      }
    } catch (error) {
      document.getElementById('loadingScreen').classList.add('hidden');
      document.getElementById('loginScreen').classList.remove('hidden');
      alert(error.message || "Error de autenticación");
    }
  });

  // Logout functionality
  document.getElementById('logoutBtn').addEventListener('click', function () {
    document.getElementById('dashboard').classList.add('hidden');
    document.getElementById('loginScreen').classList.remove('hidden');
    document.getElementById('userMenu').classList.add('hidden');
  });

  // User menu toggle
  document.getElementById('userMenuBtn').addEventListener('click', function () {
    document.getElementById('userMenu').classList.toggle('hidden');
  });

  // Close user menu when clicking outside
  document.addEventListener('click', function (event) {
    const userMenuContainer = document.getElementById('userMenuContainer');
    const userMenu = document.getElementById('userMenu');

    if (!userMenuContainer.contains(event.target) && !userMenu.classList.contains('hidden')) {
      userMenu.classList.add('hidden');
    }
  });
}