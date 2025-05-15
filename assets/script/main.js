import { setupAuthHandlers } from './authController.js';
import { setupTabHandlers } from './tabController.js';
import { setupBoxHandlers } from './boxController.js';
import { setupMedicHandlers } from './medicController.js';
import { setupDeleteHandlers } from './deleteController.js';

// Inicializar todos los controladores cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', () => {
  setupAuthHandlers();
  setupTabHandlers();
  setupBoxHandlers();
  setupMedicHandlers();
  setupDeleteHandlers();
});