package com.learn.aws.aws;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;



@Data
public class InstanceModel{
    public int amiLaunchIndex;
    public String imageId;
    public String instanceId;
    public String instanceType;
    public Object kernelId;
    public String keyName;
    public Date launchTime;
    public Monitoring monitoring;
    public Placement placement;
    public Object platform;
    public String privateDnsName;
    public String privateIpAddress;
    public ArrayList<Object> productCodes;
    public String publicDnsName;
    public String publicIpAddress;
    public Object ramdiskId;
    public State state;
    public String stateTransitionReason;
    public String subnetId;
    public String vpcId;
    public String architecture;
    public ArrayList<BlockDeviceMapping> blockDeviceMappings;
    public String clientToken;
    public boolean ebsOptimized;
    public boolean enaSupport;
    public String hypervisor;
    public Object iamInstanceProfile;
    public Object instanceLifecycle;
    public ArrayList<Object> elasticGpuAssociations;
    public ArrayList<Object> elasticInferenceAcceleratorAssociations;
    public ArrayList<NetworkInterface> networkInterfaces;
    public Object outpostArn;
    public String rootDeviceName;
    public String rootDeviceType;
    public ArrayList<SecurityGroup> securityGroups;
    public boolean sourceDestCheck;
    public Object spotInstanceRequestId;
    public Object sriovNetSupport;
    public Object stateReason;
    public ArrayList<Object> tags;
    public String virtualizationType;
    public CpuOptions cpuOptions;
    public Object capacityReservationId;
    public CapacityReservationSpecification capacityReservationSpecification;
    public HibernationOptions hibernationOptions;
    public ArrayList<Object> licenses;
    public MetadataOptions metadataOptions;
    public EnclaveOptions enclaveOptions;
    public Object bootMode;
    public String platformDetails;
    public String usageOperation;
    public Date usageOperationUpdateTime;
    public PrivateDnsNameOptions privateDnsNameOptions;
    public Object ipv6Address;


    public String volumeId;
    public String deviceName;



    @Data
    public static class Monitoring{
        public String state;
    }
    
    @Data
    public static class Placement{
        public String availabilityZone;
        public Object affinity;
        public String groupName;
        public Object partitionNumber;
        public Object hostId;
        public String tenancy;
        public Object spreadDomain;
        public Object hostResourceGroupArn;
    }
    
    @Data
    public static class State{
        public int code;
        public String name;
    }

    @Data
    public static class Ebs{
        public Date attachTime;
        public boolean deleteOnTermination;
        public String status;
        public String volumeId;
    }
    
    @Data
    public static class BlockDeviceMapping{
        public String deviceName;
        public Ebs ebs;
    }
    
    @Data
    public static class Association{
        public Object carrierIp;
        public Object customerOwnedIp;
        public String ipOwnerId;
        public String publicDnsName;
        public String publicIp;
    }
    
    @Data
    public static class Attachment{
        public Date attachTime;
        public String attachmentId;
        public boolean deleteOnTermination;
        public int deviceIndex;
        public String status;
        public int networkCardIndex;
    }
    
    @Data
    public static class Group{
        public String groupName;
        public String groupId;
    }
    
    @Data
    public static class PrivateIpAddress{
        public Association association;
        public boolean primary;
        public String privateDnsName;
        public String privateIpAddress;
    }
    
    @Data
    public static class NetworkInterface{
        public Association association;
        public Attachment attachment;
        public String description;
        public ArrayList<Group> groups;
        public ArrayList<Object> ipv6Addresses;
        public String macAddress;
        public String networkInterfaceId;
        public String ownerId;
        public String privateDnsName;
        public String privateIpAddress;
        public ArrayList<PrivateIpAddress> privateIpAddresses;
        public boolean sourceDestCheck;
        public String status;
        public String subnetId;
        public String vpcId;
        public String interfaceType;
        public ArrayList<Object> ipv4Prefixes;
        public ArrayList<Object> ipv6Prefixes;
    }
    
    @Data
    public static class SecurityGroup{
        public String groupName;
        public String groupId;
    }
    
    @Data
    public static class CpuOptions{
        public int coreCount;
        public int threadsPerCore;
    }
    
    @Data
    public static class CapacityReservationSpecification{
        public String capacityReservationPreference;
        public Object capacityReservationTarget;
    }
    
    @Data
    public static class HibernationOptions{
        public boolean configured;
    }
    
    @Data
    public static class MetadataOptions{
        public String state;
        public String httpTokens;
        public int httpPutResponseHopLimit;
        public String httpEndpoint;
        public String httpProtocolIpv6;
        public String instanceMetadataTags;
    }
    
    @Data
    public static class EnclaveOptions{
        public boolean enabled;
    }
    
    @Data
    public static class PrivateDnsNameOptions{
        public String hostnameType;
        public boolean enableResourceNameDnsARecord;
        public boolean enableResourceNameDnsAAAARecord;
    }
}


