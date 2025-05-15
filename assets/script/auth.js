// auth.js
const users = [
  {
    email: "coordinador@redsalud.cl",
    password: "12345",
    name: "Coordinador"
  }
];

function authenticate(email, password) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const user = users.find(u => u.email === email && u.password === password);
      if (user) {
        resolve({
          success: true,
          user: {
            email: user.email,
            name: user.name
          }
        });
      } else {
        reject({
          success: false,
          message: "Credenciales incorrectas"
        });
      }
    }, 1000);
  });
}

// Exporta la función para uso en módulos
export { authenticate };