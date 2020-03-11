package com.bridgelabz.cliniquemanagement.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.serviceprovider.CliniqueManagementServiceProviderImpl;
import com.bridgelabz.cliniquemanagement.utils.InputUtility;
import com.bridgelabz.cliniquemanagement.utils.LogsUtility;

public class CliniqueManagementController {

	public static void main(String[] args) {

		LogsUtility.setLog("CliniqueManagementController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "CliniqueManagementController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		CliniqueManagementServiceProviderImpl impl = new CliniqueManagementServiceProviderImpl();
		impl.readDoctorInfoFromJSONFile();
		impl.readPatientInfoFromJSONFile();
		impl.readAppointmentInfoFromJSONFile();

		boolean exit = false;

		while (!exit) {
			logger.info("choose");
			logger.info("\n1. Add New Doctor Information \n2. Add New Patient Information"
					+ "\n3. Search Doctor By ID \n4. Search Doctor by Name "
					+ "\n5. Search Doctor by specilization \n6. search doctor by availibility"
					+ "\n7. search patinet by ID\n8. search patient by name"
					+ "\n9. search patient by mobile number\n10. Add an appointment to records"
					+ "\n11. Save All Details\n12. show all the records\n13. exit");
			switch (InputUtility.intVal()) {
			case 1:
				logger.info("------------------------Adding a new doctor---------------------------");
				Doctor doctor = impl.getDoctor();
				impl.addDoctor(doctor);
				logger.info("Successfully added a new doctor details");
				break;
			case 2:
				logger.info("--------------------------Adding a new patient-------------------------");
				Patient patient = impl.getPatient();
				impl.addPatient(patient);
				logger.info("Successfully added a new patient details");
				break;
			case 3:
				logger.info("---------------------------------Searching doctor by id--------------------------");
				impl.searchDoctorByID();
				break;
			case 4:
				logger.info("---------------------------------Searching doctor by Name--------------------------");
				impl.searchDoctorByName();
				break;
			case 5:
				logger.info(
						"---------------------------------Searching doctor by specilization--------------------------");
				boolean found = impl.searchDoctorBySpecialization();
				if (found)
					logger.info("Doctor is available on the given specilization");
				else
					logger.info("Doctor is available on the given specilization thank you");
				break;
			case 6:
				logger.info(
						"---------------------------------Searching doctor by availibility--------------------------");
				logger.info("Enter the date on which you want to check the availibility of the doctor");
				String date = InputUtility.stringVal();
				logger.info("Enter the time on which you want to check the availibility of the doctor");
				double time = InputUtility.doubleVal();

				boolean available = impl.searchDoctorByAvailibility(date, time);
				if (available)
					logger.info("Doctor is available on the specified date and time");
				else
					logger.info("Doctor is not available on the specified date and time");

				break;
			case 7:
				logger.info("---------------------------------Searching patient by id--------------------------");
				logger.info("Enter the ID by which you want to search a patient");
				int iD = InputUtility.intVal();
				boolean patientFound = impl.searchPatientByID(iD);
				if (patientFound)
					logger.info("Patient found on the specified ID");
				else
					logger.info("Patient did not found on the specified Id please try with some other ID");
				break;
			case 8:
				logger.info("---------------------------------Searching patient by name--------------------------");
				impl.searchPatientByName();
				break;
			case 9:
				logger.info(
						"---------------------------------Searching patient by mobile number--------------------------");
				impl.searchPatientByMobile();
				break;
			case 10:
				logger.info("---------------------------------Add an appointment to the record--------------------------");
				impl.addAppointment();
				break;
			case 11:
				logger.info("---------------------------------Save All the records--------------------------");
				impl.save();
				break;
			case 12:
				logger.info("---------------------------------Show all records--------------------------");
				impl.showAllRecords();
				break;
			case 13:
				exit = true;
				logger.info("Successfully exited");
				logger.info("Thanks for visiting. Visit again");
				break;
			default:
				logger.info("Invalid choice ");
			}
		}
	}
}
