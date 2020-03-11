package com.bridgelabz.cliniquemanagement.serviceprovider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.AppointmentModel;
import com.bridgelabz.cliniquemanagement.model.AvailibilityModel;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.DoctorModel;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.model.PatientModel;
import com.bridgelabz.cliniquemanagement.repository.CliniqueManagementRepository;
import com.bridgelabz.cliniquemanagement.utils.InputUtility;
import com.bridgelabz.cliniquemanagement.utils.OutputUtility;

public class CliniqueManagementServiceProviderImpl implements CliniqueManagementServiceProvider {

	Logger logger = Logger.getLogger(CliniqueManagementServiceProviderImpl.class);

	private final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";

	private static int appointmentID = 100;
	private static int patientID = 100;
	private static int doctorID = 100;

	private static String doctorInfoFileName = "DoctorDetails.json";
	private static String patientInfoFileName = "PatientDetails.json";
	private static String appointmentInfoFileName = "AppointmentDetails.json";

	DoctorModel doctorModel = new DoctorModel();
	PatientModel patientModel = new PatientModel();
	AppointmentModel appointmentModel = new AppointmentModel();

	private static List<Doctor> doctorList = new ArrayList<>();
	private static List<Patient> patientList = new ArrayList<>();
	private static List<Appointment> appointmentList = new ArrayList<>();

	CliniqueManagementRepository repo = new CliniqueManagementRepository();

	@Override
	public void readDoctorInfoFromJSONFile() {
		String initialFilePath = filePath + doctorInfoFileName;
		try {
			doctorModel = (DoctorModel) repo.readFromJSONFile(initialFilePath, DoctorModel.class);
		} catch (ParseException | ClassNotFoundException e) {
			logger.error(e);
		}
		doctorList.addAll(doctorModel.getDoctors());
		logger.info("Successfully read doctor details");
	}

	@Override
	public void readPatientInfoFromJSONFile() {
		String initialFilePath = filePath + patientInfoFileName;
		try {
			patientModel = (PatientModel) repo.readFromJSONFile(initialFilePath, PatientModel.class);
		} catch (ParseException | ClassNotFoundException e) {
			logger.error(e);
		}
		patientList.addAll(patientModel.getPatientsList());
		logger.info("Successfully read patient details");
	}

	@Override
	public void readAppointmentInfoFromJSONFile() {
		String initialFilePath = filePath + appointmentInfoFileName;
		try {
			appointmentModel = (AppointmentModel) repo.readFromJSONFile(initialFilePath, AppointmentModel.class);
		} catch (ParseException | ClassNotFoundException e) {
			logger.error(e);
		}
		appointmentList.addAll(appointmentModel.getAppointmentsList());
		logger.info("Successfully read patient details");
	}

	@Override
	public void showDoctorList(List<Doctor> doctorsList, int index) {
		logger.info(doctorsList.get(index).getDoctorID());
		logger.info(doctorsList.get(index).getDoctorName());
		logger.info(doctorsList.get(index).getDoctorSpecilization());
		logger.info(doctorsList.get(index).getDoctorAvailableStatus());
		logger.info(doctorsList.get(index).getNoOfPatients());
	}

	@Override
	public void showPatientList(List<Patient> patientList, int index) {
		logger.info(patientList.get(index).getPatientID());
		logger.info(patientList.get(index).getPatientName());
		logger.info(patientList.get(index).getPatientAge());
		logger.info(patientList.get(index).getPatientMobileNumber());
	}

	@Override
	public Doctor getDoctor() {
		Doctor doctor = new Doctor();
		logger.info("--------------------getting doctor---------------------------");
		doctorID++;
		doctor.setDoctorID(doctorID);
		logger.info("Enter Doctor Name  :");
		doctor.setDoctorName("Dr. " + InputUtility.stringVal());
		logger.info("Enter Specilization of the doctor : ");
		doctor.setDoctorSpecilization(InputUtility.stringVal());
		logger.info("------------Availibility status-----------------");
		logger.info("Enter doctor IN time : ");
		AvailibilityModel availibilityModel = new AvailibilityModel();
		availibilityModel.setInTime(InputUtility.doubleVal());
		logger.info("Enter doctor OUT time");
		availibilityModel.setOutTime(InputUtility.doubleVal());
		logger.info("Enter the date on which doctor might be available");
		availibilityModel.setDate(InputUtility.stringVal());
		doctor.setDoctorAvailableStatus(availibilityModel);
		doctor.setNoOfPatients(0);
		return doctor;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctorList.add(doctor);
		boolean exit = false;
		while (!exit) {
			logger.info("successfully added doctor");
			logger.info("choose \n1. Add new doctor \n2. Exit from the menu");
			if (InputUtility.intVal() == 1) {
				exit = false;
				doctorList.add(getDoctor());
			} else {
				exit = true;
				logger.info("No doctor added as per your choice please select 1 if you want to add a doctor");
				logger.info("--------------------successfully exited--------------------------");
			}
		}
	}

	@Override
	public Patient getPatient() {
		logger.info("---------------------------------Adding Patient Details--------------------------------");
		Patient patient = new Patient();
		patientID++;
		patient.setPatientID(patientID);
		logger.info("Please enter patient name : ");
		patient.setPatientName(InputUtility.stringVal());
		logger.info("Please enter patient age : ");
		patient.setPatientAge(InputUtility.intVal());
		logger.info("Please enter patient contact number");
		patient.setPatientMobileNumber(InputUtility.stringVal());
		return patient;
	}

	@Override
	public void addPatient(Patient patient) {
		boolean exit = false;
		patientList.add(patient);
		while (!exit) {
			logger.info("----------------------Patient added successfully-------------------------------");
			logger.info("Choose \n1. Add new Patient \n2. Exit from the menu");
			if (InputUtility.intVal() == 1) {
				exit = false;
				patientList.add(getPatient());
			} else {
				exit = true;
				logger.info("No patient added as per your choice please choose 1 to add patient");
				logger.info("-----------------Successfully exited from the menu-------------------");
			}
		}
	}

	@Override
	public void searchDoctorByID() {
		if (doctorList.size() > 0) {
			logger.info("Enter official doctor id");
			int id = InputUtility.intVal();
			doctorList.forEach(i -> {
				if (id == i.getDoctorID()) {
					logger.info("Doctor found on id The name of the doctor is " + i.getDoctorName());
				} else {
					logger.info("Doctor ID does not exists in the records please recheck and enter correct doctor ID");
				}
			});
		}

	}

	@Override
	public void searchDoctorByName() {
		if (doctorList.size() > 0) {
			logger.info("Enter doctor name to be searched : ");
			String doctorName = InputUtility.stringVal();
			for(int i=0; i<doctorList.size();i++) {
				if (doctorName.equals(doctorList.get(i).getDoctorName())) {
					logger.info("Doctor found the doctor details are as follows \n" + doctorList.get(i).getDoctorID() + "\n" +doctorList.get(i).getDoctorName() + "\n" + doctorList.get(i).getDoctorSpecilization());
				}
			}
		} else
			logger.info("doctors List is empty");
	}

	@Override
	public String getDoctorNameBySpecialization() {
		String doctorName[] = { "" };
		if (doctorList.size() > 0) {
			logger.info("Enter Doctor Specialization to search a doctor who is specilist in that field");
			String specilization = InputUtility.stringVal();
			doctorList.forEach(i -> {
				if (specilization.equalsIgnoreCase(i.getDoctorSpecilization()))
					doctorName[0] = i.getDoctorName();
			});
			return doctorName[0];
		} else {
			logger.info("Doctors list is empty");
			return doctorName[0];
		}
	}

	public boolean searchDoctorBySpecialization() {
		boolean doctorFound = false;
		if (doctorList.size() > 0) {
			logger.info("Enter Doctor Specialization to search a doctor who is specilist in that field");
			String specilization = InputUtility.stringVal();
			for(int i=0;i<doctorList.size(); i++) {	
				if (specilization.equalsIgnoreCase(doctorList.get(i).getDoctorSpecilization())) {
						doctorFound = true;
						return doctorFound;
				}
			}
		}logger.info("Doctors list is empty");
				return doctorFound;
	}

	@Override
	public boolean searchDoctorByAvailibility(String str, double time) {
		if (!doctorList.isEmpty()) {
			boolean doctorAvailable = false;
			for (int i = 0; i < doctorList.size(); i++) {
				if (str.equals(doctorList.get(i).getDoctorAvailableStatus().getDate())
						&& (time >= doctorList.get(i).getDoctorAvailableStatus().getInTime()
								&& time <= doctorList.get(i).getDoctorAvailableStatus().getOutTime())) {
					logger.info("List of doctors available on the specified list are as follows");
					showDoctorList(doctorList, i);
					doctorAvailable = true;
				}
			}
			if (doctorAvailable)
				return true;
		}
		return false;
	}

	@Override
	public int getPatientIndexByID(int iD) {
		for (int i = 0; i < patientList.size(); i++) {
			if (patientID == patientList.get(i).getPatientID()) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public boolean searchPatientByID(int iD) {
		if (!patientList.isEmpty()) {
			for (int i = 0; i < patientList.size(); i++) {
				if (iD == patientList.get(i).getPatientID()) {
					showPatientList(patientList, i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void searchPatientByName() {
		if (!patientList.isEmpty()) {
			logger.info("Enter patient name to be searched : ");
			String patientName = InputUtility.stringVal();
			patientList.forEach(i -> {
				if (patientName.equalsIgnoreCase(i.getPatientName())) {
					logger.info("Patient Found and the details are as follows");
					logger.info(i.getPatientID());
					logger.info(i.getPatientName());
					logger.info(i.getPatientAge());
					logger.info(i.getPatientMobileNumber());
				}
			});
		} else
			logger.info("patients list is empty");
	}

	@Override
	public void searchPatientByMobile() {
		if (!patientList.isEmpty()) {
			logger.info("Enter patient mobile number to be searched : ");
			String mobileNumber = InputUtility.stringVal();
			patientList.forEach(i -> {
				if (mobileNumber.equals(i.getPatientMobileNumber())) {
					logger.info("Patient Found and the details are as follows");
					logger.info(i.getPatientID());
					logger.info(i.getPatientName());
					logger.info(i.getPatientAge());
					logger.info(i.getPatientMobileNumber());
				}
			});
		} else
			logger.info("patients list is empty");
	}

	@Override
	public void addAppointment() {
		if (doctorList.isEmpty()) {
			logger.info("Doctors list is empty");
		} else {
			if (patientList.isEmpty()) {
				logger.info("Patient list is empty");
			} else {
				checkAppointmentFacilities();
			}
		}
	}

	@Override
	public void checkAppointmentFacilities() {
		logger.info("---------------------------Validating appointment facilities--------------------------- ");
		logger.info("Enter specialization in which you are searching for a doctor");
		String specilization = InputUtility.stringVal();
		boolean doctorFound = searchDoctorBySpecialization();
		if (!doctorFound) {
			logger.info("doctor could not be found");
		} else {
			for (int i = 0; i < doctorList.size(); i++) {
				if (doctorList.get(i).getDoctorSpecilization().equalsIgnoreCase(specilization)) {
					logger.info("Dr. " + doctorList.get(i).getDoctorName() + " is available on "
							+ doctorList.get(i).getDoctorAvailableStatus().getDate());
					logger.info("Would you like to proceed enter yes or no");
					String yesOrNo = InputUtility.stringVal();
					if (yesOrNo.equalsIgnoreCase("no"))
						logger.info("Thank you visit again");
					else if (yesOrNo.equals("yes")) {
						logger.info("Enter time on which you want to check whether the doctor is available or no");
						double time = InputUtility.doubleVal();
						boolean doctorAvailableOnTime = searchDoctorByAvailibility(
								doctorList.get(i).getDoctorAvailableStatus().getDate(), time);
						if (!doctorAvailableOnTime)
							logger.info(
									"Doctor is not available on the time you selected please try on someother date and time");
						else {
							logger.info("Doctor is available on your time");
							if (doctorList.get(i).getNoOfPatients() > 5)
								logger.info(
										"Doctor already have maximum number of appointments please wait for your next appointment");
							else {
								logger.info("Enter Patient ID : ");
								int patientID = InputUtility.intVal();
								if (!searchPatientByID(patientID))
									logger.info(
											"No patient is registered on the ID that you have entered please choose a valid ID");
								else {
									logger.info("To book appointment enter yes else enter no");
									if (InputUtility.stringVal().equalsIgnoreCase("yes")) {
										Appointment appointment = getAppointment(i, patientID);
										saveAppointment(appointment);
									}
								}

							}

						}
					}
				}
			}
		}
	}

	@Override
	public void save() {
		// saving doctor list
		if (!doctorList.isEmpty()) {
			doctorModel.setDoctors(doctorList);
			try {
				repo.writeToJSONFile(filePath + doctorInfoFileName, doctorModel);
			} catch (FileNotFoundException e) {
				logger.error(e);
			}
		} else
			logger.info("Doctor list is empty");
		logger.info("Saved doctor details successfully");

		// saving appointment
		if (!appointmentList.isEmpty()) {
			appointmentModel.setAppointmentsList(appointmentList);
			try {
				repo.writeToJSONFile(filePath + appointmentInfoFileName, appointmentModel);
			} catch (FileNotFoundException fnfe) {
				logger.error(fnfe);
			}
		}
		logger.info("Saved appointment details successfully");

		// saving patient details
		if (!patientList.isEmpty()) {
			patientModel.setPatientsList(patientList);
			try {
				repo.writeToJSONFile(filePath + patientInfoFileName, patientModel);
			} catch (FileNotFoundException fnfe) {
				logger.error(fnfe);
			}
		}
		logger.info("Patient details saved successfully");
	}

	@Override
	public void showAllRecords() {
		if (!doctorList.isEmpty()) {
			OutputUtility.println("Number of patients \t Doctor Record");
			for (int i = 0; i < doctorList.size(); i++) {
				OutputUtility.print(doctorList.get(i).getNoOfPatients() + "\t\t");
				OutputUtility.print(doctorList.get(i).getDoctorID() + "\t");
				showDoctorList(doctorList, i);
			}
		} else
			logger.info("doctor list is empty");

		if (!patientList.isEmpty()) {
			OutputUtility.println("Patients Record");
			for (int i = 0; i < patientList.size(); i++) {
				showPatientList(patientList, i);
			}
		} else
			logger.info("patient list is empty");

		if (!appointmentList.isEmpty()) {
			OutputUtility.println("Appointment Details record");
			for (int i = 0; i < appointmentList.size(); i++) {
				logger.info(appointmentList.get(i).getAppID());
				logger.info(appointmentList.get(i).getAssignedPatientID());
				logger.info(appointmentList.get(i).getAssignedPatientName());
				logger.info(appointmentList.get(i).getAssignedPatientMobileNumber());
				logger.info(appointmentList.get(i).getDoctorID());
				logger.info(appointmentList.get(i).getDoctorName());
				logger.info(appointmentList.get(i).getDoctorStatus());
			}
		} else
			logger.info("appointment list is empty");

	}

	@Override
	public Appointment getAppointment(int index, int patientID) {
		Appointment appointment = new Appointment();
		appointmentID++;
		appointment.setAppID(appointmentID);
		appointment.setDoctorID(doctorList.get(index).getDoctorID());
		appointment.setDoctorName(doctorList.get(index).getDoctorName());
		appointment.setDoctorStatus(doctorList.get(index).getDoctorAvailableStatus().getDate());
		appointment.setAssignedPatientID(patientID);
		int iD = getPatientIndexByID(patientID);
		appointment.setAssignedPatientName(patientList.get(iD).getPatientName());
		appointment.setAssignedPatientMobileNumber(patientList.get(iD).getPatientMobileNumber());
		int noOfPatients = doctorList.get(index).getNoOfPatients();
		noOfPatients = noOfPatients + 1;
		doctorList.get(index).setNoOfPatients(noOfPatients);
		doctorModel.setDoctors(doctorList);
		return appointment;
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		appointmentList.add(appointment);
		appointmentModel.setAppointmentsList(appointmentList);
		try {
			repo.writeToJSONFile(filePath + doctorInfoFileName, doctorModel);
			repo.writeToJSONFile(filePath + appointmentInfoFileName, appointmentModel);
		} catch (IOException e) {
			logger.error(e);
		}
		logger.info("Äppointment booked");
	}

}
