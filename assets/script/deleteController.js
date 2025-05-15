export function setupDeleteHandlers() {
  // Delete box buttons
  const deleteBoxButtons = document.querySelectorAll('.delete-box-btn');
  deleteBoxButtons.forEach(button => {
    button.addEventListener('click', function () {
      const boxId = this.getAttribute('data-id');
      let boxInfo = '';

      if (boxId === 'B001') boxInfo = 'Box 1 - Consulta General';
      else if (boxId === 'B002') boxInfo = 'Box 2 - Pediatría';
      else if (boxId === 'B003') boxInfo = 'Box 3 - Traumatología';
      else if (boxId === 'B004') boxInfo = 'Box 4 - Cardiología';

      document.getElementById('deleteInfo').textContent = boxInfo;
      document.getElementById('confirmDeleteBtn').setAttribute('data-id', boxId);
      document.getElementById('deleteModal').classList.remove('hidden');
    });
  });

  // Delete medic buttons
  const deleteMedicButtons = document.querySelectorAll('.delete-medic-btn');
  deleteMedicButtons.forEach(button => {
    button.addEventListener('click', function () {
      const boxId = this.getAttribute('data-id');
      let boxInfo = '';
      
      if (boxId === '20.226.121-6') {
        boxInfo = 'Dra. Ana Martínez';
      }

      document.getElementById('deleteInfo').textContent = boxInfo;
      document.getElementById('confirmDeleteBtn').setAttribute('data-id', boxId);
      document.getElementById('deleteModal').classList.remove('hidden');
    });
  });

  // Close delete modal
  document.getElementById('closeDeleteModal').addEventListener('click', function () {
    document.getElementById('deleteModal').classList.add('hidden');
  });

  document.getElementById('cancelDeleteBtn').addEventListener('click', function () {
    document.getElementById('deleteModal').classList.add('hidden');
  });

  // Confirm delete
  document.getElementById('confirmDeleteBtn').addEventListener('click', function () {
    const Id = this.getAttribute('data-id');
    document.getElementById('deleteModal').classList.add('hidden');
    alert('Elemento eliminado correctamente');
  });
}