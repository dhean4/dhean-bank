-- Create the users table based on your Entity
CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,
                                     first_name VARCHAR(100),
    last_name VARCHAR(100),
    other_name VARCHAR(100),
    gender VARCHAR(20),
    address TEXT,
    state_of_origin VARCHAR(100),
    account_number VARCHAR(20) UNIQUE,
    account_balance DECIMAL(15,2) DEFAULT 0.00,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(20),
    alternate_phone_number VARCHAR(20),
    status VARCHAR(50) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Create indexes for better performance
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_users_account_number ON users(account_number);
CREATE INDEX IF NOT EXISTS idx_users_phone_number ON users(phone_number);

-- -- Insert sample data (optional)
-- INSERT INTO users (
--     first_name, last_name, other_name, gender, address,
--     state_of_origin, account_number, account_balance,
--     email, phone_number, status
-- ) VALUES
--       (
--           'John', 'Doe', 'Michael', 'Male',
--           '123 Main Street, Lagos', 'Lagos',
--           '1000000001', 5000.00,
--           'john.doe@email.com', '+2348012345678', 'ACTIVE'
--       ),
--       (
--           'Jane', 'Smith', 'Ada', 'Female',
--           '456 Victoria Island, Lagos', 'Ogun',
--           '1000000002', 7500.50,
--           'jane.smith@email.com', '+2348087654321', 'ACTIVE'
--       )
--     ON CONFLICT (email) DO NOTHING;