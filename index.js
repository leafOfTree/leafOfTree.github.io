document.addEventListener('DOMContentLoaded', () => {
  if (!Notification) {
    alert('Notification not available! Try a differnt browser')
  }
  if (!Notification.permission !== 'granted') {
    Notification.requestPermission()
  }
})

function notify() {
  if (Notification.permission !== 'granted') {
    Notification.requestPermission()
  } else {
    new Notification('Reminder', {
      body: 'Hey, please take a break'
    })
  }
}

setInterval(() => {
  const now = new Date()
  const hours = now.getHours()
  const mins = now.getMinutes()
  if (hours > 9 && hours < 20 && mins === 59) {
    notify()
  }
}, 1000*60)
