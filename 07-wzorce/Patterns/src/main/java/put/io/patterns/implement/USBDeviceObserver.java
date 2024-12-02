package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {
    private int lastUsbDevicesNumber = 0;

    @Override
    public void update(SystemMonitor monitor) {
        if (lastUsbDevicesNumber != monitor.getLastSystemState().getUsbDevices()) {
            System.out.println("Number of usb devices changed");
            lastUsbDevicesNumber = monitor.getLastSystemState().getUsbDevices();
        }
    }
}
