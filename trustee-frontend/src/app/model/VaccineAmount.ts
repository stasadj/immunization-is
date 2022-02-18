export interface VaccineAmount {
    type: string;
    manufacturer: string;
    series: { amount: number; serialNumber: number }[];
}
