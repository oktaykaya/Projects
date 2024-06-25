async function submitRecipe() {
    try {
      const recipeCategory = document.getElementById('recipeCategory').value;
      const recipeName = document.getElementById('recipeName').value;
      const recipeIngredients = document.getElementById('recipeIngredients').value;
      const recipePhoto = document.getElementById('recipePhoto').files[0];
  
      // if(!recipeCategory==="none"){
      //   console.log("geldi")
      // }
  
      // Create a FormData object to easily send binary data (like files)
      const formData = new FormData();
      formData.append('category', recipeCategory);
      formData.append('name', recipeName);
      formData.append('ingredients', recipeIngredients);
      formData.append('photo', recipePhoto);
  
      // Send the data to the server
  
      const sectiginDiv = document.getElementById("recipesContainer");
  
      const response = await fetch("http://localhost:8081/submit-recipe",{
        method: 'POST',
        body: formData,
      })
        .then((response) => response.json())
        .then((data) => {
        sectiginDiv.innerHTML = data.recipes.map(recipe => `
        <div>
          <h2>${recipe.name}</h2>
          <p>Category: ${recipe.category}</p>
          <p>Ingredients: ${recipe.ingredients.join(', ')}</p>
          <img src="${recipe.photo}" alt="Recipe Photo">
        </div>`).join('');
    });
  
      if (!response.ok) {
        throw new Error('Error submitting recipe');
      }
  
      // Simulating a delay for demonstration purposes (replace this with your actual logic)
      await new Promise(resolve => setTimeout(resolve, 1000));
  
      // Hide the form elements
      document.getElementById('recipeForm').style.display = 'none';
  
      // Display success message and button
      const successMessage = document.getElementById('successMessage');
      successMessage.style.display = 'block';
  
    } catch (error) {
      console.error('Error submitting recipe:', error);
      // Handle error if submission fails
    }
  }
  
    
    function submitAnotherRecipe() {
      // Show the form elements again
      document.getElementById('recipeForm').style.display = 'flex';
    
      // Hide the success message
      const successMessage = document.getElementById('successMessage');
      successMessage.style.display = 'none';
    
      // Scroll to the top of the page
      window.scrollTo(0, 0);
    }
    
    function goToTarifGonderPage() {
      // Redirect to the "Tarif Gönder" page
      window.location.href = 'tarifGönder.html';
    }
    
    
  
    async function takePhoto() {
      try {
        const stream = await navigator.mediaDevices.getUserMedia({ video: true });
        const video = document.createElement('video');
        document.body.appendChild(video);
        video.srcObject = stream;
        await video.play();
    
        const canvas = document.createElement('canvas');
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        canvas.getContext('2d').drawImage(video, 0, 0, canvas.width, canvas.height);
    
        const imageUrl = canvas.toDataURL('image/png');
        displayPhotoPreview(imageUrl);
    
        stream.getTracks().forEach(track => track.stop());
        document.body.removeChild(video);
      } catch (error) {
        console.error('Error accessing camera:', error);
      }
    }
    
    function triggerFileInput() {
      const input = document.getElementById('recipePhoto');
      input.click();
    }
    
    function uploadPhoto() {
      const input = document.getElementById('recipePhoto');
      input.click(); // Trigger the file input
    
      input.addEventListener('change', function () {
        const file = input.files[0];
    
        if (file) {
          const imageUrl = URL.createObjectURL(file);
          displayPhotoPreview(imageUrl);
        }
      });
    }
    
    function displayPhotoPreview(imageUrl) {
      const previewImage = document.getElementById('recipePhotoPreview');
      previewImage.src = imageUrl;
      previewImage.style.display = 'block';
    }
  
    