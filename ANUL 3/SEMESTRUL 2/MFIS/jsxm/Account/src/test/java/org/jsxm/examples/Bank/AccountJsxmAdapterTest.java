package org.jsxm.examples.Bank;
import jsxm.testAdapters.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class AccountJsxmAdapterTest{

    @Test
    public void test_k2_1_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_2_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_3_readbalance() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("getBalance_Error", obj.getBalance());
    }

    @Test
    public void test_k2_4_open_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_5_open_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_6_open_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_7_open_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_8_open_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_9_open_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_10_open_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_11_open_close_readbalance() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("closeOut", obj.close());
        assertEquals("getBalance_Error", obj.getBalance());
    }

    @Test
    public void test_k2_12_open_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_13_open_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_14_open_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_15_open_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_16_open_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_17_open_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_18_open_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_19_open_readbalance_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_20_open_readbalance_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_21_open_readbalance_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_22_open_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_23_open_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_24_open_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_25_open_readbalance_close_readbalance() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("getBalance_Error", obj.getBalance());
    }

    @Test
    public void test_k2_26_open_deposit_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_27_open_deposit_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_28_open_deposit_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_29_open_deposit_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_30_open_deposit_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_31_open_deposit_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_32_open_deposit_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_33_open_deposit_withdrawN_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_34_open_deposit_withdrawN_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_35_open_deposit_withdrawN_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_36_open_deposit_withdrawN_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_37_open_deposit_withdrawN_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_38_open_deposit_withdrawN_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_39_open_deposit_withdrawN_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_40_open_deposit_withdraw0_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_41_open_deposit_withdraw0_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_42_open_deposit_withdraw0_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_43_open_deposit_withdraw0_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_44_open_deposit_withdraw0_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_45_open_deposit_withdraw0_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_46_open_deposit_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_47_open_deposit_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_48_open_deposit_readbalance_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_49_open_deposit_readbalance_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_50_open_deposit_readbalance_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_51_open_deposit_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_52_open_deposit_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_53_open_readbalance_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_54_open_readbalance_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_55_open_readbalance_deposit_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_56_open_readbalance_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_57_open_readbalance_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_58_open_readbalance_deposit_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_59_open_readbalance_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_60_open_readbalance_deposit_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_61_open_readbalance_deposit_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_62_open_readbalance_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_63_open_readbalance_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_64_open_readbalance_deposit_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_65_open_readbalance_readbalance_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_66_open_readbalance_readbalance_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_67_open_readbalance_readbalance_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_68_open_readbalance_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_69_open_readbalance_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_70_open_readbalance_readbalance_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_71_open_readbalance_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_72_open_readbalance_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_73_open_readbalance_readbalance_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_74_open_deposit_withdraw0_close_readbalance() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("getBalance_Error", obj.getBalance());
    }

    @Test
    public void test_k2_75_open_deposit_deposit_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_76_open_deposit_deposit_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_77_open_deposit_deposit_deposit_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_78_open_deposit_deposit_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_79_open_deposit_deposit_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_80_open_deposit_deposit_deposit_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_81_open_deposit_deposit_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_15", obj.withdraw(15));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_82_open_deposit_deposit_deposit_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_15", obj.withdraw(15));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_83_open_deposit_deposit_deposit_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_15", obj.withdraw(15));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_84_open_deposit_deposit_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_15", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_85_open_deposit_deposit_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_15", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_86_open_deposit_deposit_deposit_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_15", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_87_open_deposit_deposit_withdrawN_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_88_open_deposit_deposit_withdrawN_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_89_open_deposit_deposit_withdrawN_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_90_open_deposit_deposit_withdrawN_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_91_open_deposit_deposit_withdrawN_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_92_open_deposit_deposit_withdrawN_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_93_open_deposit_deposit_withdrawN_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_94_open_deposit_deposit_withdrawN_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_95_open_deposit_deposit_withdrawN_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_96_open_deposit_deposit_withdrawN_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_97_open_deposit_deposit_withdrawN_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_98_open_deposit_deposit_withdrawN_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_99_open_deposit_deposit_withdraw0_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_100_open_deposit_deposit_withdraw0_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_101_open_deposit_deposit_withdraw0_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_102_open_deposit_deposit_withdraw0_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_103_open_deposit_deposit_withdraw0_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_104_open_deposit_deposit_withdraw0_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_105_open_deposit_deposit_withdraw0_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_106_open_deposit_deposit_withdraw0_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_107_open_deposit_deposit_withdraw0_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_108_open_deposit_deposit_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_109_open_deposit_deposit_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_110_open_deposit_deposit_readbalance_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_111_open_deposit_deposit_readbalance_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_112_open_deposit_deposit_readbalance_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_113_open_deposit_deposit_readbalance_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_114_open_deposit_deposit_readbalance_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_115_open_deposit_deposit_readbalance_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_116_open_deposit_deposit_readbalance_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_117_open_deposit_deposit_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_118_open_deposit_deposit_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_119_open_deposit_deposit_readbalance_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_120_open_deposit_withdrawN_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_121_open_deposit_withdrawN_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_122_open_deposit_withdrawN_deposit_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_123_open_deposit_withdrawN_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_124_open_deposit_withdrawN_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_125_open_deposit_withdrawN_deposit_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_126_open_deposit_withdrawN_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_127_open_deposit_withdrawN_deposit_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_128_open_deposit_withdrawN_deposit_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_9", obj.withdraw(9));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_129_open_deposit_withdrawN_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_130_open_deposit_withdrawN_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_131_open_deposit_withdrawN_deposit_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_9", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_132_open_deposit_withdrawN_withdrawN_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_133_open_deposit_withdrawN_withdrawN_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_134_open_deposit_withdrawN_withdrawN_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_135_open_deposit_withdrawN_withdrawN_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_136_open_deposit_withdrawN_withdrawN_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_137_open_deposit_withdrawN_withdrawN_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_138_open_deposit_withdrawN_withdrawN_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_3", obj.withdraw(3));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_139_open_deposit_withdrawN_withdrawN_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_3", obj.withdraw(3));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_140_open_deposit_withdrawN_withdrawN_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_3", obj.withdraw(3));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_141_open_deposit_withdrawN_withdrawN_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_3", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_142_open_deposit_withdrawN_withdrawN_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_3", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_143_open_deposit_withdrawN_withdrawN_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_3", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_144_open_deposit_withdrawN_withdraw0_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_145_open_deposit_withdrawN_withdraw0_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_146_open_deposit_withdrawN_withdraw0_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_147_open_deposit_withdrawN_withdraw0_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_148_open_deposit_withdrawN_withdraw0_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_149_open_deposit_withdrawN_withdraw0_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_150_open_deposit_withdrawN_withdraw0_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_151_open_deposit_withdrawN_withdraw0_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_152_open_deposit_withdrawN_withdraw0_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_153_open_deposit_withdrawN_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_154_open_deposit_withdrawN_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_155_open_deposit_withdrawN_readbalance_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_156_open_deposit_withdrawN_readbalance_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_157_open_deposit_withdrawN_readbalance_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_158_open_deposit_withdrawN_readbalance_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_159_open_deposit_withdrawN_readbalance_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_160_open_deposit_withdrawN_readbalance_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_161_open_deposit_withdrawN_readbalance_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_162_open_deposit_withdrawN_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_163_open_deposit_withdrawN_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_164_open_deposit_withdrawN_readbalance_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_165_open_deposit_withdraw0_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_166_open_deposit_withdraw0_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_167_open_deposit_withdraw0_deposit_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_168_open_deposit_withdraw0_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_169_open_deposit_withdraw0_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_170_open_deposit_withdraw0_deposit_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_171_open_deposit_withdraw0_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_172_open_deposit_withdraw0_deposit_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_173_open_deposit_withdraw0_deposit_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_174_open_deposit_withdraw0_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_175_open_deposit_withdraw0_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_176_open_deposit_withdraw0_deposit_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_177_open_deposit_withdraw0_readbalance_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_178_open_deposit_withdraw0_readbalance_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_179_open_deposit_withdraw0_readbalance_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_180_open_deposit_withdraw0_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_181_open_deposit_withdraw0_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_182_open_deposit_withdraw0_readbalance_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_183_open_deposit_withdraw0_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_184_open_deposit_withdraw0_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_185_open_deposit_withdraw0_readbalance_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_186_open_deposit_readbalance_deposit_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_187_open_deposit_readbalance_deposit_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_188_open_deposit_readbalance_deposit_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_189_open_deposit_readbalance_deposit_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_190_open_deposit_readbalance_deposit_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_191_open_deposit_readbalance_deposit_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_192_open_deposit_readbalance_deposit_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_193_open_deposit_readbalance_deposit_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_194_open_deposit_readbalance_deposit_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("withdrawOut_10", obj.withdraw(10));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_195_open_deposit_readbalance_deposit_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_196_open_deposit_readbalance_deposit_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_197_open_deposit_readbalance_deposit_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_10", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_198_open_deposit_readbalance_withdrawN_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_199_open_deposit_readbalance_withdrawN_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_200_open_deposit_readbalance_withdrawN_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_201_open_deposit_readbalance_withdrawN_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_202_open_deposit_readbalance_withdrawN_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_203_open_deposit_readbalance_withdrawN_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_204_open_deposit_readbalance_withdrawN_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_205_open_deposit_readbalance_withdrawN_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_206_open_deposit_readbalance_withdrawN_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("withdrawOut_4", obj.withdraw(4));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_207_open_deposit_readbalance_withdrawN_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_208_open_deposit_readbalance_withdrawN_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_209_open_deposit_readbalance_withdrawN_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("getBalanceOut_4", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_210_open_deposit_readbalance_withdraw0_close_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_211_open_deposit_readbalance_withdraw0_close_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_212_open_deposit_readbalance_withdraw0_close_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
        assertEquals("deposit_Error", obj.deposit(5));
    }

    @Test
    public void test_k2_213_open_deposit_readbalance_withdraw0_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_214_open_deposit_readbalance_withdraw0_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_215_open_deposit_readbalance_withdraw0_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_216_open_deposit_readbalance_withdraw0_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_217_open_deposit_readbalance_withdraw0_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_218_open_deposit_readbalance_withdraw0_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("getBalanceOut_0", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_219_open_deposit_readbalance_readbalance_deposit_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_220_open_deposit_readbalance_readbalance_deposit_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_221_open_deposit_readbalance_readbalance_deposit_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_222_open_deposit_readbalance_readbalance_withdrawN_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_223_open_deposit_readbalance_readbalance_withdrawN_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_224_open_deposit_readbalance_readbalance_withdrawN_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_1", obj.withdraw(1));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_225_open_deposit_readbalance_readbalance_withdraw0_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_226_open_deposit_readbalance_readbalance_withdraw0_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("closeOut", obj.close());
    }

    @Test
    public void test_k2_227_open_deposit_readbalance_readbalance_withdraw0_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("withdrawOut_5", obj.withdraw(5));
        assertEquals("depositOut_5", obj.deposit(5));
    }

    @Test
    public void test_k2_228_open_deposit_readbalance_readbalance_readbalance_open() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("open_Error", obj.open());
    }

    @Test
    public void test_k2_229_open_deposit_readbalance_readbalance_readbalance_close() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("close_Error", obj.close());
    }

    @Test
    public void test_k2_230_open_deposit_readbalance_readbalance_readbalance_deposit() {
        AccountAdapter obj = new AccountAdapter();
        assertEquals("openOut", obj.open());
        assertEquals("depositOut_5", obj.deposit(5));
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("getBalanceOut_5", obj.getBalance());
        assertEquals("depositOut_5", obj.deposit(5));
    }

//
// Helper methods for definitions...
//


}
// End of generated Test Case

