export function setupBoxHandlers() {
  function checkBoxStatus() {
    const status = document.getElementById('boxStatus').value;
    const doctorContainer = document.getElementById('doctorAssignmentContainer');

    if (status === 'occupied') {
      doctorContainer.classList.remove('hidden');
    } else {
      doctorContainer.classList.add('hidden');
      document.getElementById('assignedDoctor').value = '';
    }
  }

  // Box modal functionality
  document.getElementById('addBoxBtn').addEventListener('click', function () {
    document.getElementById('boxModalTitle').textContent = 'Agregar Box';
    document.getElementById('boxId').value = '';
    document.getElementById('boxName').value = '';
    document.getElementById('boxType').value = '';
    document.getElementById('boxStatus').value = 'available';
    document.getElementById('boxDescription').value = '';
    document.getElementById('boxModal').classList.remove('hidden');
    document.getElementById('assignedDoctor').value = '';
    checkBoxStatus();
  });

  document.getElementById('boxStatus').addEventListener('change', checkBoxStatus);

  // Close box modal
  document.getElementById('closeBoxModal').addEventListener('click', function () {
    document.getElementById('boxModal').classList.add('hidden');
  });

  document.getElementById('cancelBoxBtn').addEventListener('click', function () {
    document.getElementById('boxModal').classList.add('hidden');
  });

  // Save box
  document.getElementById('saveBoxBtn').addEventListener('click', function () {
    document.getElementById('boxModal').classList.add('hidden');
    alert('Box guardado correctamente');
  });

  // Edit box buttons
  const editBoxButtons = document.querySelectorAll('.edit-box-btn');
  editBoxButtons.forEach(button => {
    button.addEventListener('click', function () {
      const boxId = this.getAttribute('data-id');
      document.getElementById('boxModalTitle').textContent = 'Editar Box';
      document.getElementById('boxId').value = boxId;

      if (boxId === 'B001') {
        document.getElementById('boxName').value = 'Box 1';
        document.getElementById('boxType').value = 'general';
        document.getElementById('boxStatus').value = 'available';
        document.getElementById('boxDescription').value = 'Box para consultas generales';
      } else if (boxId === 'B002') {
        document.getElementById('boxName').value = 'Box 2';
        document.getElementById('boxType').value = 'pediatrics';
        document.getElementById('boxStatus').value = 'occupied';
        document.getElementById('assignedDoctor').value = 'M002';
        document.getElementById('boxDescription').value = 'Box para consultas pediátricas';
      } else if (boxId === 'B003') {
        document.getElementById('boxName').value = 'Box 3';
        document.getElementById('boxType').value = 'traumatology';
        document.getElementById('boxStatus').value = 'maintenance';
        document.getElementById('boxDescription').value = 'Box en mantenimiento por reparación de equipo';
      } else if (boxId === 'B004') {
        document.getElementById('boxName').value = 'Box 4';
        document.getElementById('boxType').value = 'cardiology';
        document.getElementById('boxStatus').value = 'occupied';
        document.getElementById('assignedDoctor').value = 'M003';
        document.getElementById('boxDescription').value = 'Box para consultas cardiológicas';
      }

      checkBoxStatus();
      document.getElementById('boxModal').classList.remove('hidden');
    });
  });
}