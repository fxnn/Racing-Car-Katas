package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmTest {

  @Test
  public void beforeCheck__alarmIsOff() {
    Alarm alarm = new Alarm(new Sensor());
    assertFalse(alarm.isAlarmOn());
  }

  @Test
  public void afterSomeChecks__alarmWasOn() {
    Alarm alarm = new Alarm(new Sensor());
    for (int i = 0; i < 100; i++) {
      alarm.check();
      if (alarm.isAlarmOn()) {
        return;
      }
    }
    fail("Alarm was never on");
  }

  @Test
  public void sensorReportsLowPressure__alarmIsOn() {
    Alarm alarm = new Alarm(mockSensor(16));
    alarm.check();
    assertTrue(alarm.isAlarmOn());
  }

  @Test
  public void sensorReportsHighPressure__alarmIsOn() {
    Alarm alarm = new Alarm(mockSensor(22));
    alarm.check();
    assertTrue(alarm.isAlarmOn());
  }

  @Test
  public void sensorReportsNormalPressure__alarmIsOff() {
    Alarm alarm = new Alarm(mockSensor(18));
    alarm.check();
    assertFalse(alarm.isAlarmOn());
  }

  private static Sensor mockSensor(final int nextPressurePsiValue) {
    return new Sensor() {
      @Override
      public double popNextPressurePsiValue() {
        return nextPressurePsiValue;
      }
    };
  }

}
