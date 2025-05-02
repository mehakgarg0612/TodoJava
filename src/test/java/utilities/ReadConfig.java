package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Config file not found!" + e.getMessage());
        }
    }

    public String getAppURL() {
        return prop.getProperty("appUrl");
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getPassword() {
        return prop.getProperty("pwd");
    }
    
    public String getTaskName() {
    	return prop.getProperty("taskName");
    }
    
    public String getDescriptionArea() {
    	return prop.getProperty("taskDescription");
    }
    
    public String getStartDate() {
    	return prop.getProperty("startDate");
    }
//    
    public String getDueDate() {
    	return prop.getProperty("dueDate");
    }
//    
    
    
//    public String getSelectPriority() {
//    	return prop.getProperty("selectPriority");
//    }
    
    
    public String getTaskPriority() {
    	return prop.getProperty("taskPriority");
    }
    
    public String getSearchName()
    {
    	return prop.getProperty("searchName");
    }
    
    public String getTaskDescriptionOfCreatedTask() {
    	return prop.getProperty("taskDescriptionOfCreatedTask");
    }
    
    public String getTaskOnHoldReason() {
		return prop.getProperty("taskOnHoldReason");
	}
    
    public String getRestartTaskReason() {
    	return prop.getProperty("taskRestartReason");
    }
    
    
    //MY PROFILE DATA
    
    public String getFirstName() {
		return prop.getProperty("firstName");
	}
    
	public String getLastName() {
		return prop.getProperty("lastName");
	}
	
   //UPDATE PASSWORD
//	public String getOldPassword() {	
//		return prop.getProperty("oldPassword");
//	}				
	
	public String getNewPassword() {
		return prop.getProperty("newPassword");
	}
	public String getConfirmPassword() {
		return prop.getProperty("confirmPassword");
	}
	
	
	//REGISTRATION DATA
	
	public String getRegFirstName() {
		return prop.getProperty("firstNameReg");
	}
	
	public String getRegLastName() {
		return prop.getProperty("lastNameReg");
	}
	
		public String getRegEmail() {
		return prop.getProperty("emailIdReg");
		
	}
		
		public String getAlreadyRegisteredEmail() {
			return prop.getProperty("alreadyRegEmail");
		}
		
		public String getRegEmployeeCode() {
			return prop.getProperty("empCodeReg");
		}
		
		public String getAlreadyRegisteredEmpCode() {
			return prop.getProperty("empCodeRegAlreadyReg");
		}
		
		public String getRegPassword() {
		return prop.getProperty("passwordReg");
	}
			
		
		public String getRegConfirmPassword() {
		return prop.getProperty("confirmPasswordReg");
	}

		public String getAppRegURL() {
	        return prop.getProperty("appUrlReg");
	    }
		
		

		
	
	
	
    
}

