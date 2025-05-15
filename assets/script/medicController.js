export function setupMedicHandlers() {
  // Medic modal functionality
  document.getElementById('addMedicBtn').addEventListener('click', function () {
    document.getElementById('medicModalTitle').textContent = 'Agregar Médico';
    document.getElementById('medicId').value = '';
    document.getElementById('medicName').value = '';
    document.getElementById('medicSpeciality').value = '';
    document.getElementById('medicStatus').value = 'available';
    document.getElementById('medicBoxAssigned').value = '';
    document.getElementById('medicScheduleUp').value = '';
    document.getElementById('medicScheduleDown').value = '';
    document.getElementById('medicModal').classList.remove('hidden');
    document.getElementById('assignedDoctor').value = '';
  });

  // Close medic modal
  document.getElementById('closeMedicModal').addEventListener('click', function () {
    document.getElementById('medicModal').classList.add('hidden');
  });

  document.getElementById('cancelMedicBtn').addEventListener('click', function () {
    document.getElementById('medicModal').classList.add('hidden');
  });

  // Save medic
  document.getElementById('saveMedicBtn').addEventListener('click', function () {
    document.getElementById('medicModal').classList.add('hidden');
    alert('Médico guardado correctamente');
  });

  // Edit medic buttons
  const editMedicButtons = document.querySelectorAll('.edit-medic-btn');
  editMedicButtons.forEach(button => {
    button.addEventListener('click', function () {
      const medicId = this.getAttribute('data-id');
      document.getElementById('medicModalTitle').textContent = 'Editar Médico';
      document.getElementById('boxId').value = boxId;

      if (medicId === '20.226.121-6') {
        document.getElementById('medicId').value = '20.226.121-6';
        document.getElementById('medicName').value = 'Dra. Ana Martínez';
        document.getElementById('medicSpeciality').value = 'Traumatología';
        document.getElementById('medicStatus').value = 'available';
        document.getElementById('medicBoxAssigned').value = '-';
        document.getElementById('medicScheduleUp').value = '10:00';
        document.getElementById('medicScheduleDown').value = '16:00';
      }

      document.getElementById('medicModal').classList.remove('hidden');
    });
  });
}