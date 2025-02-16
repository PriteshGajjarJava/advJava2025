<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Menu Selection</title>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .menu-container {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .search-wrapper {
            position: relative;
            display: flex;
            align-items: center;
            width: 200px;
        }

        .search-wrapper input {
            width: 100%;
            padding: 8px 30px 8px 8px;
        }

        .search-icon {
            position: absolute;
            right: 8px;
            color: gray;
            pointer-events: none;
        }

        .dropdown-menu {
            position: absolute;
            background-color: white;
            border: 1px solid #ccc;
            list-style: none;
            margin: 0;
            padding: 5px 0;
            width: 100%;
            top: 38px;
            display: none;
            z-index: 100;
        }

        .dropdown-menu li {
            padding: 8px;
            cursor: pointer;
        }

        .dropdown-menu li:hover {
            background-color: #f0f0f0;
        }

        input[type="number"] {
            width: 60px;
            padding: 8px;
        }

        .add-btn {
            padding: 8px 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 18px;
        }

        .add-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="menu-container">
        <!-- Search with Dropdown -->
        <div class="search-wrapper">
            <input type="text" id="menuSearch" placeholder="Search menu..." autocomplete="off">
            <i class="fas fa-search search-icon"></i>
            <ul id="menuDropdown" class="dropdown-menu"></ul>
        </div>

        <!-- Quantity -->
        <input type="number" id="menuQty" min="1" value="1">

        <!-- Add Button -->
        <button class="add-btn" id="addItemBtn">+</button>
    </div>

    <div id="output"></div>

    <script>
        const menuItems = [
            'Pizza', 'Burger', 'Pasta', 'Sandwich', 'Salad',
            'French Fries', 'Soup', 'Grilled Chicken', 'Biryani', 'Noodles'
        ];

        const searchInput = document.getElementById('menuSearch');
        const dropdown = document.getElementById('menuDropdown');
        const qtyInput = document.getElementById('menuQty');
        const addButton = document.getElementById('addItemBtn');
        const outputDiv = document.getElementById('output');

        // Populate dropdown based on search
        searchInput.addEventListener('input', function() {
            const query = this.value.toLowerCase();
            dropdown.innerHTML = '';

            if (query.length === 0) {
                dropdown.style.display = 'none';
                return;
            }

            const filteredItems = menuItems.filter(item =>
                item.toLowerCase().includes(query)
            );

            if (filteredItems.length === 0) {
                dropdown.style.display = 'none';
                return;
            }

            filteredItems.forEach(item => {
                const li = document.createElement('li');
                li.textContent = item;
                li.addEventListener('click', () => {
                    searchInput.value = item;
                    dropdown.style.display = 'none';
                });
                dropdown.appendChild(li);
            });

            dropdown.style.display = 'block';
        });

        // Hide dropdown when clicking outside
        document.addEventListener('click', function(e) {
            if (!e.target.closest('.search-wrapper')) {
                dropdown.style.display = 'none';
            }
        });

        // Add item (For demo purposes, showing output below)
        addButton.addEventListener('click', function() {
            const selectedItem = searchInput.value;
            const qty = qtyInput.value;

            if (!selectedItem || !menuItems.includes(selectedItem)) {
                alert('Please select a valid menu item.');
                return;
            }

            if (qty <= 0) {
                alert('Quantity must be at least 1.');
                return;
            }

            outputDiv.innerHTML += `<p>Added: ${qty} x ${selectedItem}</p>`;
            searchInput.value = '';
            qtyInput.value = '1';
        });
    </script>

</body>
</html>
