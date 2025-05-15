export function setupTabHandlers() {
  function showLoading() {
    document.getElementById('floatingSpinner').style.display = 'block';
  }

  function hideLoading() {
    document.getElementById('floatingSpinner').style.display = 'none';
  } 

  // Tab switching
  document.getElementById('boxesTabBtn').addEventListener('click', function () {
    showLoading();
    setTimeout(() => {
      document.getElementById('boxesTabContent').classList.remove('hidden');
      document.getElementById('doctorsTabContent').classList.add('hidden');
      document.getElementById('boxesTabBtn').classList.add('text-sky-600', 'border-sky-500');
      document.getElementById('boxesTabBtn').classList.remove('text-gray-500', 'border-transparent');
      document.getElementById('doctorsTabBtn').classList.add('text-gray-500', 'border-transparent');
      document.getElementById('doctorsTabBtn').classList.remove('text-sky-600', 'border-sky-500');
      hideLoading();
    }, 500);
  });

  document.getElementById('doctorsTabBtn').addEventListener('click', function () {
    showLoading();
    setTimeout(() => {
      document.getElementById('doctorsTabContent').classList.remove('hidden');
      document.getElementById('boxesTabContent').classList.add('hidden');
      document.getElementById('doctorsTabBtn').classList.add('text-sky-600', 'border-sky-500');
      document.getElementById('doctorsTabBtn').classList.remove('text-gray-500', 'border-transparent');
      document.getElementById('boxesTabBtn').classList.add('text-gray-500', 'border-transparent');
      document.getElementById('boxesTabBtn').classList.remove('text-sky-600', 'border-sky-500');
      hideLoading();
    }, 500);
  });
}